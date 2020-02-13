<?php

namespace VeloBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use VeloBundle\Entity\Velo;
use Symfony\Component\HttpFoundation\Request;
class CarteController extends Controller
{

    public function indexAction(Request $request)
    {
        $session = $request->getSession();
        $panier = $session->get('panier', []);
        $panierwithdata = [];




        foreach ($panier as $id => $quantite) {
            $panierwithdata[] = [
                'produit' => $this->getDoctrine()->getRepository(Velo::class)->find($id),
                'quantite' => $quantite
            ];
        }
        $total = 0;
        foreach ($panierwithdata as $item) {
            $totalitem = $item['produit']->getPrixvente() * $item['quantite'];
            $total += $totalitem;
        }
        return $this->render('@Velo/Velo/panier.html.twig', ['items' => $panierwithdata, 'total' => $total,'session'=>$session]);
    }

    public function addAction($id, Request $request)
    {
        $session = $request->getSession();
        $panier = $session->get('panier', []);
        if (!empty($panier[$id])) {
            $panier[$id]++;
        } else {
            $panier[$id] = 1;
        }
        $session->set('panier', $panier);
        $velos = $this->getDoctrine()->getRepository(Velo::class)->findAll();
        return $this->render('@Velo/Velo/Velo.html.twig', array('velos' => $velos));
    }

    public function removeAction($id, Request $request)
    {
        $session = $request->getSession();
        $panier = $session->get('panier', []);
        if (!empty($panier[$id])) {
            unset($panier[$id]);
        }
        $session->set('panier', $panier);
        return $this->redirectToRoute('panier_select');
    }
}
