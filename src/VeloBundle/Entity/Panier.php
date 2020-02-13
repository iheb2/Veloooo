<?php

namespace VeloBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Panier
 *
 * @ORM\Table(name="panier")
 * @ORM\Entity(repositoryClass="VeloBundle\Repository\PanierRepository")
 */
class Panier
{
    /**
     * @ORM\ManyToMany(targetEntity="Velo", mappedBy="commandes")
     */
    private $velos;

    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    private $id;

    /**
     * @var int
     *
     * @ORM\Column(name="nombreproduit", type="integer")
     */
    private $nombreproduit;

    /**
     * @var float
     *
     * @ORM\Column(name="prixapayer", type="float")
     */
    private $prixapayer;


    /**
     * Get id
     *
     * @return int
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set nombreproduit
     *
     * @param integer $nombreproduit
     *
     * @return Panier
     */
    public function setNombreproduit($nombreproduit)
    {
        $this->nombreproduit = $nombreproduit;

        return $this;
    }

    /**
     * Get nombreproduit
     *
     * @return int
     */
    public function getNombreproduit()
    {
        return $this->nombreproduit;
    }

    /**
     * Set prixapayer
     *
     * @param float $prixapayer
     *
     * @return Panier
     */
    public function setPrixapayer($prixapayer)
    {
        $this->prixapayer = $prixapayer;

        return $this;
    }

    /**
     * Get prixapayer
     * Get prixapayer
     *
     * @return float
     */
    public function getPrixapayer()
    {
        return $this->prixapayer;
    }

}

