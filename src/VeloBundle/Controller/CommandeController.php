<?php

namespace VeloBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use VeloBundle\Entity\Commande ;
use VeloBundle\Form\CommandeType;
use Symfony\Component\HttpFoundation\Request;

class CommandeController extends Controller
{
    public function indexxAction()
    {
        return $this->render('@Velo/Commande/createcmd.html.twig');
    }

    public function indexxxAction($id)
    {
        $commande=$this->getDoctrine()->getRepository(Commande::class)->find($id);
        return $this->render('@Velo/Commande/readcmdClient.html.twig',array('commande'=>$commande));
    }





    public function readcmdAction()
    {   //Fetching Objects (Clubs) from the Database
        $commandes=$this->getDoctrine()->getManager()->getRepository(Commande::class)->findAll();
        return $this->render('@Velo/Commande/readcmd.html.twig', array('commandes'=>$commandes ));
    }
    public function createcmdAction(Request $request)
    {   //create an object to store our data after the form submission
        $commande=new Commande(); // instancer une entite et l stocker dans une variable
// n oublie pas de lui changer le nom
        //prepare the form with the function: createForm()
        $form=$this->createForm(CommandeType::class,$commande);  //ClubType :form name  // $club c est la variable ou on a stocke  //formname found src/bundlname/forum
        //extract the form answer from the received request
        $form=$form->handleRequest($request);
        //if this form is valid
        $commande->setStatutcde("non confirme");
        $commande->setTotalcommande(100);
        $commande->setPaiementvalide(1);
        $commande->setDatecommande(new \DateTime('now'));

        if($form->isValid()){
            //create an entity manager object
            $em=$this->getDoctrine()->getManager();
            //persist the object $club in the ORM
            $em->persist($commande);
            //update the data base with flush
            $em->flush();
            //redirect the route after the add
            return $this->redirectToRoute('readcmd_commande'); // redirect to main page (using routing name for the function read or affichage fount in routingyml n oublie  pas de le changer
        }
        return $this->render('@Velo/Commande/createcmd.html.twig', array('form'=>$form->createView()));
    }

    public function deletecmdAction($id)
    {
        //get the object to be removed given the submitted id
        $em = $this->getDoctrine()->getManager();
        $commande= $em->getRepository(Commande::class)->find($id);
        //remove from the ORM
        $em->remove($commande);
        //update the data base
        $em->flush();
        return $this->redirectToRoute("readcmd_commande"); // noublie pas de le veerifier read or affivhage selon le contexte
    }

    public function updatecmdAction(Request $request, $id)
    {
        $commande=new Commande(); // instancer une entite et l stocker dans une variable

        //first step:
        //get the club with $id with manager permission
        $em=$this->getDoctrine()->getManager();
        $commande= $em->getRepository(Commande::class)->find($id);
        $form = $this->createForm(CommandeType::class,$commande); // $club la variable ou on a stocker il faut la changer
        $form->handleRequest($request);
// Club :entity name
        //third step:
        // check is the from is sent
        if (($form->isSubmitted())) {
            //update our object given the sent data in the request
// setNom w get (nom) njobouhom ml Entity
            $em= $this->getDoctrine()->getManager();
            $em->persist($commande);
            $em->flush();
            //Redirect to the read
            return $this->redirectToRoute('readcmd_commande'); // selon controleer changer le nom de read a afficher selon  le contexte
        }
        //second step:
        // send the view to the user
        return $this->render('@Velo/Commande/updatecmd.html.twig', array('form' => $form->createView()));
    }


    public function readcmdbackAction()
    {   //Fetching Objects (Clubs) from the Database
        $commandes=$this->getDoctrine()->getManager()->getRepository(Commande::class)->findAll();
        return $this->render('@Velo/Commande/readcmdback.html.twig', array('commandes'=>$commandes ));
    }


    public function deletecmdbackAction($id)
    {
        //get the object to be removed given the submitted id
        $em = $this->getDoctrine()->getManager();
        $commande= $em->getRepository(Commande::class)->find($id);
        //remove from the ORM
        $em->remove($commande);
        //update the data base
        $em->flush();
        return $this->redirectToRoute("readcmdback_commande"); // noublie pas de le veerifier read or affivhage selon le contexte
    }

    public function updatecmdbackAction(Request $request, $id)
    {
        $commande=new Commande(); // instancer une entite et l stocker dans une variable

        //first step:
        //get the club with $id with manager permission
        $em=$this->getDoctrine()->getManager();
        $commande= $em->getRepository(Commande::class)->find($id);
        $form = $this->createForm(CommandeType::class,$commande); // $club la variable ou on a stocker il faut la changer
        $form->handleRequest($request);
// Club :entity name
        //third step:
        // check is the from is sent
        if (($form->isSubmitted())) {
            //update our object given the sent data in the request
// setNom w get (nom) njobouhom ml Entity
            $em= $this->getDoctrine()->getManager();
            $em->persist($commande);
            $em->flush();
            //Redirect to the read
            return $this->redirectToRoute('readcmdback_commande'); // selon controleer changer le nom de read a afficher selon  le contexte
        }
        //second step:
        // send the view to the user
        return $this->render('@Velo/Commande/updatecmdback.html.twig', array('form' => $form->createView()));
    }


}
