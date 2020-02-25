<?php

namespace FrontBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class AdminController extends Controller
{
    public function backAction()
    {
        return $this->render('@Front/Default/admin.html.twig');
    }

}
