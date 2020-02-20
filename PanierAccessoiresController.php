<?php

namespace AccessoiresBundle\Controller;

use AccessoiresBundle\Entity\PanierAccessoires;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

/**
 * Panieraccessoire controller.
 *
 */
class PanierAccessoiresController extends Controller
{
    /**
     * Lists all panierAccessoire entities.
     *
     */
    public function indexAction()
    {
        $em = $this->getDoctrine()->getManager();

        $panierAccessoires = $em->getRepository('AccessoiresBundle:PanierAccessoires')->findAll();

        return $this->render('panieraccessoires/index.html.twig', array(
            'panierAccessoires' => $panierAccessoires,
        ));
    }

    /**
     * Creates a new panierAccessoire entity.
     *
     */
    public function newAction(PanierAccessoires $panierAccessoires,Request $request)
    {
        $panierAccessoire = new Panieraccessoire();
        $form = $this->createForm('AccessoiresBundle\Form\PanierAccessoiresType', $panierAccessoire);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($panierAccessoire);
            $em->flush();

            return $this->redirectToRoute('panieraccessoires_show', array('id' => $panierAccessoire->getId()));
        }

        return $this->render('panieraccessoires/new.html.twig', array(
            'panierAccessoire' => $panierAccessoire,
            'form' => $form->createView(),
        ));
    }

    /**
     * Finds and displays a panierAccessoire entity.
     *
     */
    public function showAction(PanierAccessoires $panierAccessoire)
    {
        $deleteForm = $this->createDeleteForm($panierAccessoire);

        return $this->render('panieraccessoires/show.html.twig', array(
            'panierAccessoire' => $panierAccessoire,
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Displays a form to edit an existing panierAccessoire entity.
     *
     */
    public function editAction(Request $request, PanierAccessoires $panierAccessoire)
    {
        $deleteForm = $this->createDeleteForm($panierAccessoire);
        $editForm = $this->createForm('AccessoiresBundle\Form\PanierAccessoiresType', $panierAccessoire);
        $editForm->handleRequest($request);

        if ($editForm->isSubmitted() && $editForm->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('panieraccessoires_edit', array('id' => $panierAccessoire->getId()));
        }

        return $this->render('panieraccessoires/edit.html.twig', array(
            'panierAccessoire' => $panierAccessoire,
            'edit_form' => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Deletes a panierAccessoire entity.
     *
     */
    public function deleteAction(Request $request, PanierAccessoires $panierAccessoire)
    {
        $form = $this->createDeleteForm($panierAccessoire);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->remove($panierAccessoire);
            $em->flush();
        }

        return $this->redirectToRoute('panieraccessoires_index');
    }

    /**
     * Creates a form to delete a panierAccessoire entity.
     *
     * @param PanierAccessoires $panierAccessoire The panierAccessoire entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createDeleteForm(PanierAccessoires $panierAccessoire)
    {
        return $this->createFormBuilder()
            ->setAction($this->generateUrl('panieraccessoires_delete', array('id' => $panierAccessoire->getId())))
            ->setMethod('DELETE')
            ->getForm()
        ;
    }
}
