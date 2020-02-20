<?php

namespace AccessoiresBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class DefaultController extends Controller
{
    public function indexAction()
    {
        return $this->render('AccessoiresBundle:Default:index.html.twig');
    }
}
