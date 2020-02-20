<?php

namespace AccessoiresBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * PanierAccessoires
 *
 * @ORM\Table(name="panier_accessoires")
 * @ORM\Entity(repositoryClass="AccessoiresBundle\Repository\PanierAccessoiresRepository")
 */
class PanierAccessoires
{
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
     * @ORM\Column(name="quantite", type="integer", nullable=true)
     */
    private $quantite;

    /**
     * @ORM\ManyToOne(targetEntity="AccessoiresBundle\Entity\Accessoire",inversedBy="paniers")
     */
    private $accessoire;

    /**
     * @ORM\ManyToOne(targetEntity="AccessoiresBundle\Entity\Panier",inversedBy="accessoires")
     */
    private $panier;

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
     * Set quantite
     *
     * @param integer $quantite
     *
     * @return PanierAccessoires
     */
    public function setQuantite($quantite)
    {
        $this->quantite = $quantite;

        return $this;
    }

    /**
     * Get quantite
     *
     * @return int
     */
    public function getQuantite()
    {
        return $this->quantite;
    }

    /**
     * @return mixed
     */
    public function getAccessoire()
    {
        return $this->accessoire;
    }

    /**
     * @param mixed $accessoire
     */
    public function setAccessoire($accessoire)
    {
        $this->accessoire = $accessoire;
    }

    /**
     * @return mixed
     */
    public function getPanier()
    {
        return $this->panier;
    }

    /**
     * @param mixed $panier
     */
    public function setPanier($panier)
    {
        $this->panier = $panier;
    }


}

