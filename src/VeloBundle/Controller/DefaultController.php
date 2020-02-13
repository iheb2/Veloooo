<?php

namespace VeloBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class DefaultController extends Controller
{
    public function indexAction()
    {
        return $this->render('@Velo/Default/index.html.twig');
    }


    public function indexbackkAction()
    {
        return $this->render('@Velo/Default/indexback.html.twig');
    }
}
