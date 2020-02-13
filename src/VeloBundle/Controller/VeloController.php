<?php

namespace VeloBundle\Controller;
use VeloBundle\Entity\Velo;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use VeloBundle\Form\VeloType ;
class VeloController extends Controller
{
    public function indexAction($id)
    {
        $velo=$this->getDoctrine()->getRepository(Velo::class)->find($id);
        return $this->render('@Velo/Velo/plusdedetails.twig',array('velo'=>$velo));
    }


    public function readAction()

    {   //Fetching Objects (Clubs) from the Database
        $velos=$this->getDoctrine()->getManager()->getRepository(Velo::class)->findAll();
        return $this->render('@Velo/Velo/Velo.html.twig', array('velos'=>$velos ));
    }

    public function createAction(Request $request)
    {   //create an object to store our data after the form submission
        $velo=new Velo(); // instancer une entite et l stocker dans une variable
        //prepare the form with the function: createForm()
        $form=$this->createForm(VeloType::class,$velo);
        //extract the form answer from the received request
        $form=$form->handleRequest($request);
        //if this form is valid
        if($form->isValid()){
            //create an entity manager object
            $em=$this->getDoctrine()->getManager();
            //$velo->uploadProfilePicture($this->getParameter('upload_directory'));
            //persist the object $club in the ORM
            $em->persist($velo);
            //update the data base with flush
            $em->flush();
            //redirect the route after the add
            return $this->redirectToRoute('read_velo'); // redirect to main page (using routing name for the function read or affichage fount in routingyml n oublie  pas de le changer
        }
        return $this->render('@Velo/Velo/create.html.twig', array(  'form'=>$form->createView() ));
    }
    public function updateAction(Request $request, $id)
    {
        //first step:
        //get the club with $id with manager permission
        $em=$this->getDoctrine()->getManager();
        $velo = $em->getRepository(Velo::class)->find($id); // $club la variable ou on a stocker il faut la changer
// Club :entity name
        //third step:
        // check is the from is sent
        if ($request->isMethod('POST')) {
            //update our object given the sent data in the request
// setNom w get (nom) njobouhom ml Entity
            $velo ->setNom($request->get('nom'));
            $velo ->setPrixachat($request->get('prixachat'));
            $velo ->setPrixvente($request->get('prixvente'));
            $velo ->setQuantite($request->get('quantite'));
            $velo ->setDescription($request->get('description'));
            //fresh the data base
            $em->flush();
            //Redirect to the read
            return $this->redirectToRoute('read_velo'); // selon controleer changer le nom de read a afficher selon  le contexte
        }
        //second step:
        // send the view to the user
        return $this->render('@Velo/Velo/update.html.twig', array(
            'velo' => $velo));
    }
    public function deleteAction($id)
    {
        //get the object to be removed given the submitted id
        $em = $this->getDoctrine()->getManager();
        $velo= $em->getRepository(Velo::class)->find($id);
        //remove from the ORM
        $em->remove($velo);
        //update the data base
        $em->flush();
        return $this->redirectToRoute("read_velo"); // noublie pas de le verifier read or affivhage selon le contexte
    }


    public function createbackAction(Request $request)
    {   //create an object to store our data after the form submission
        $velo=new Velo(); // instancer une entite et l stocker dans une variable
        //prepare the form with the function: createForm()
        $form=$this->createForm(VeloType::class,$velo);
        //extract the form answer from the received request
        $form=$form->handleRequest($request);
        //if this form is valid
        if($form->isValid()){
            //create an entity manager object
            $em=$this->getDoctrine()->getManager();
            //persist the object $club in the ORM
            $em->persist($velo);
            //update the data base with flush
            $em->flush();
            //redirect the route after the add
            return $this->redirectToRoute('readback_velo'); // redirect to main page (using routing name for the function read or affichage fount in routingyml n oublie  pas de le changer
        }
        return $this->render('@Velo/Velo/createback.html.twig', array(  'form'=>$form->createView() ));
    }

    public function readbackAction()

    {   //Fetching Objects (Clubs) from the Database
        $velos=$this->getDoctrine()->getManager()->getRepository(Velo::class)->findAll();
        return $this->render('@Velo/Velo/Veloback.html.twig', array('velos'=>$velos ));
    }

    public function deletebackAction($id)
    {
        //get the object to be removed given the submitted id
        $em = $this->getDoctrine()->getManager();
        $velo= $em->getRepository(Velo::class)->find($id);
        //remove from the ORM
        $em->remove($velo);
        //update the data base
        $em->flush();
        return $this->redirectToRoute("readback_velo"); // noublie pas de le verifier read or affivhage selon le contexte
    }

    public function updatebackAction(Request $request, $id)
    {
        //first step:
        //get the club with $id with manager permission
        $em=$this->getDoctrine()->getManager();
        $velo = $em->getRepository(Velo::class)->find($id); // $club la variable ou on a stocker il faut la changer
// Club :entity name
        //third step:
        // check is the from is sent
        if ($request->isMethod('POST')) {
            //update our object given the sent data in the request
// setNom w get (nom) njobouhom ml Entity
            $velo ->setNom($request->get('nom'));
            $velo ->setPrixachat($request->get('prixachat'));
            $velo ->setPrixvente($request->get('prixvente'));
            $velo ->setQuantite($request->get('quantite'));
            $velo ->setDescription($request->get('description'));
            //fresh the data base
            $em->flush();
            //Redirect to the read
            return $this->redirectToRoute('readback_velo'); // selon controleer changer le nom de read a afficher selon  le contexte
        }
        //second step:
        // send the view to the user
        return $this->render('@Velo/Velo/updateback.html.twig', array(
            'velo' => $velo));
    }

}
