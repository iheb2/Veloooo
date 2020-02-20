<?php

namespace AccessoiresBundle\Controller;

use AccessoiresBundle\Entity\Commande;
use Dompdf\Dompdf;
use Dompdf\Options;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Validator\Constraints\Date;

/**
 * Commande controller.
 *
 */
class CommandeController extends Controller
{
    /**
     * Lists all commande entities.
     *
     */
    public function indexAction()
    {
        $em = $this->getDoctrine()->getManager();

        $commandes = $em->getRepository('AccessoiresBundle:Commande')->findAll();

        return $this->render('@Accessoires/commande/index.html.twig', array(
            'commandes' => $commandes,
        ));
    }

    /**
     * Creates a new commande entity.
     *
     */
    public function newAction(Request $request,float $sommeTotale)
    {
        $commande = new Commande();
        $form = $this->createForm('AccessoiresBundle\Form\CommandeType', $commande);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $user   =   $this->getUser();
            $panier =$user->getPanier();
            $panierAccessoires=$panier->getAccessoires();
            foreach($panierAccessoires as $accessoire)
            {
                $accessoire->getAccessoire()->setQuantite($accessoire->getAccessoire()->getQuantite()-$accessoire->getQuantite());
            }
            foreach($panierAccessoires as $accessoire)
            {
                $this->getDoctrine()->getManager()->remove($accessoire);
            }
            $commande->setDateCommande(new \DateTime());
            $commande->setTotaleCommande($sommeTotale);
            $commande->setStatus('non paye');
            $commande->setValide(false);
            // Configure Dompdf according to your needs
            $pdfOptions = new Options();
            $pdfOptions->set('defaultFont', 'Arial');
            // Instantiate Dompdf with our options
            $dompdf = new Dompdf($pdfOptions);
            // Retrieve the HTML generated in our twig file
            $html = $this->renderView('@Accessoires/commande/pdf.html.twig', array(
                'panier'  => $panier,
                'sommeTotale'=>$sommeTotale,
            ));
            // Load HTML to Dompdf
            $dompdf->loadHtml($html);
            // (Optional) Setup the paper size and orientation 'portrait' or 'portrait'
            $dompdf->setPaper('A4', 'portrait');
            // Render the HTML as PDF
            $dompdf->render();
            // Output the generated PDF to Browser (inline view)
            $dompdf->stream("invoicepdf", [
                "Attachment" => false
            ]);

            $em = $this->getDoctrine()->getManager();
            $em->persist($commande);
            $em->flush();

            return $this->redirectToRoute('accessoire_index_front');
        }

        return $this->render('@Accessoires/commande/new.html.twig', array(
            'commande' => $commande,
            'form' => $form->createView(),
        ));
    }

    /**
     * Finds and displays a commande entity.
     *
     */
    public function showAction(Commande $commande)
    {
        $deleteForm = $this->createDeleteForm($commande);

        return $this->render('@Accessoires/commande/show.html.twig', array(
            'commande' => $commande,
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Displays a form to edit an existing commande entity.
     *
     */
    public function editAction(Request $request, Commande $commande)
    {
        $deleteForm = $this->createDeleteForm($commande);
        $editForm = $this->createForm('AccessoiresBundle\Form\CommandeType', $commande);
        $editForm->handleRequest($request);

        if ($editForm->isSubmitted() && $editForm->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('commande_edit', array('id' => $commande->getId()));
        }

        return $this->render('@Accessoires/commande/edit.html.twig', array(
            'commande' => $commande,
            'edit_form' => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Deletes a commande entity.
     *
     */
    public function deleteAction(Request $request, Commande $commande)
    {
        $form = $this->createDeleteForm($commande);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->remove($commande);
            $em->flush();
        }

        return $this->redirectToRoute('commande_index');
    }

    /**
     * Creates a form to delete a commande entity.
     *
     * @param Commande $commande The commande entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createDeleteForm(Commande $commande)
    {
        return $this->createFormBuilder()
            ->setAction($this->generateUrl('commande_delete', array('id' => $commande->getId())))
            ->setMethod('DELETE')
            ->getForm()
        ;
    }
    public function validerAction(Commande $commande,string $valide)
    {
        if($valide==='valider')
        {
            $commande->setValide(true);
            $commande->setStatus('paye');
        }
        else
        {
            $commande->setValide(false);
            $commande->setStatus('non paye');
        }
        $this->getDoctrine()->getManager()->flush();
        return $this->redirectToRoute('commande_index');
    }
}
