<?php

namespace ProjBundle\Controller;

use ProjBundle\Entity\Cours;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;use Symfony\Component\HttpFoundation\Request;

/**
 * Cour controller.
 *
 * @Route("admin/cours")
 */
class CoursController extends Controller
{
    /**
     * Lists all cour entities.
     *
     * @Route("/", name="cours_index")
     * @Method("GET")
     */
    public function indexAction()
    {
        $em = $this->getDoctrine()->getManager();

        $cours = $em->getRepository('ProjBundle:Cours')->findAll();

        return $this->render('@Proj/Default/backend/cours/index.html.twig', array(
            'cours' => $cours,
        ));
    }






    /**
     *
     * @Route("/tri", name="cours_tri")
     * @Method("GET")
     */
    public function indextriAction()
    {
        $em = $this->getDoctrine()->getManager();

        $cours = $em->getRepository('ProjBundle:Cours')->findAllTri();

        return $this->render('@Proj/Default/backend/cours/index.html.twig', array(
            'cours' => $cours,
        ));
    }

    /**
     *
     * @Route("/tri2", name="cours_tri2")
     * @Method("GET")
     */
    public function indextri2Action()
    {
        $em = $this->getDoctrine()->getManager();

        $cours = $em->getRepository('ProjBundle:Cours')->findAllTri2();

        return $this->render('@Proj/Default/backend/cours/index.html.twig', array(
            'cours' => $cours,
        ));
    }

    /**
     *
     * @Route("/search", name="search")
     * @Method("post")
     */
    public function searchAction(Request $request)
    {
        $em = $this->getDoctrine()->getManager();
        $key = $request->get('c');
        $cours = $em->getRepository('ProjBundle:Cours')->search("$key");

        return $this->render('@Proj/Default/backend/cours/index.html.twig', array(
            'cours' => $cours,
        ));
    }






















    /**
     * Creates a new cour entity.
     *
     * @Route("/new", name="cours_new")
     * @Method({"GET", "POST"})
     */
    public function newAction(Request $request)
    {
        $cour = new Cours();
        $form = $this->createForm('ProjBundle\Form\CoursType', $cour);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            if ($cour->getDateFin() > $cour->getDateDebut())
            {
                $em = $this->getDoctrine()->getManager();
                $em->persist($cour);
                $em->flush();

                return $this->redirectToRoute('cours_show', array('id' => $cour->getId()));
            }else{
                return $this->redirectToRoute('cours_new');
            }

        }

        return $this->render('@Proj/Default/backend/cours/new.html.twig', array(
            'cour' => $cour,
            'form' => $form->createView(),
        ));
    }

    /**
     * Finds and displays a cour entity.
     *
     * @Route("/{id}", name="cours_show")
     * @Method("GET")
     */
    public function showAction(Cours $cour)
    {
        $deleteForm = $this->createDeleteForm($cour);

        return $this->render('@Proj/Default/backend/cours/show.html.twig', array(
            'cour' => $cour,
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Displays a form to edit an existing cour entity.
     *
     * @Route("/{id}/edit", name="cours_edit")
     * @Method({"GET", "POST"})
     */
    public function editAction(Request $request, Cours $cour)
    {
        $deleteForm = $this->createDeleteForm($cour);
        $editForm = $this->createForm('ProjBundle\Form\CoursType', $cour);
        $editForm->handleRequest($request);

        if ($editForm->isSubmitted() && $editForm->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('cours_edit', array('id' => $cour->getId()));
        }

        return $this->render('@Proj/Default/backend/cours/edit.html.twig', array(
            'cour' => $cour,
            'edit_form' => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Deletes a cour entity.
     *
     * @Route("/delete/{id}", name="cours_delete")
     * @Method("DELETE")
     */
    public function deleteAction(Request $request, Cours $cour)
    {
        $form = $this->createDeleteForm($cour);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->remove($cour);
            $em->flush();
        }

        return $this->redirectToRoute('cours_index');
    }

    /**
     * Creates a form to delete a cour entity.
     *
     * @param Cours $cour The cour entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createDeleteForm(Cours $cour)
    {
        return $this->createFormBuilder()
            ->setAction($this->generateUrl('cours_delete', array('id' => $cour->getId())))
            ->setMethod('DELETE')
            ->getForm()
        ;
    }
}
