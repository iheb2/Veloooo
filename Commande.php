<?php

namespace AccessoiresBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Commande
 *
 * @ORM\Table(name="commande")
 * @ORM\Entity(repositoryClass="AccessoiresBundle\Repository\CommandeRepository")
 */
class Commande
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
     * @var \DateTime
     *
     * @ORM\Column(name="dateCommande", type="date", nullable=true)
     */
    private $dateCommande;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="dateReglement", type="date")
     */
    private $dateReglement;

    /**
     * @var string
     *
     * @ORM\Column(name="moyen", type="string", length=255, nullable=true)
     */
    private $moyen;

    /**
     * @var float
     *
     * @ORM\Column(name="totaleCommande", type="float", nullable=true)
     */
    private $totaleCommande;

    /**
     * @var bool
     *
     * @ORM\Column(name="valide", type="boolean", nullable=true)
     */
    private $valide;

    /**
     * @var string
     *
     * @ORM\Column(name="status", type="string", length=255, nullable=true)
     */
    private $status;


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
     * Set dateCommande
     *
     * @param \DateTime $dateCommande
     *
     * @return Commande
     */
    public function setDateCommande($dateCommande)
    {
        $this->dateCommande = $dateCommande;

        return $this;
    }

    /**
     * Get dateCommande
     *
     * @return \DateTime
     */
    public function getDateCommande()
    {
        return $this->dateCommande;
    }

    /**
     * Set dateReglement
     *
     * @param \DateTime $dateReglement
     *
     * @return Commande
     */
    public function setDateReglement($dateReglement)
    {
        $this->dateReglement = $dateReglement;

        return $this;
    }

    /**
     * Get dateReglement
     *
     * @return \DateTime
     */
    public function getDateReglement()
    {
        return $this->dateReglement;
    }

    /**
     * Set moyen
     *
     * @param string $moyen
     *
     * @return Commande
     */
    public function setMoyen($moyen)
    {
        $this->moyen = $moyen;

        return $this;
    }

    /**
     * Get moyen
     *
     * @return string
     */
    public function getMoyen()
    {
        return $this->moyen;
    }

    /**
     * Set totaleCommande
     *
     * @param float $totaleCommande
     *
     * @return Commande
     */
    public function setTotaleCommande($totaleCommande)
    {
        $this->totaleCommande = $totaleCommande;

        return $this;
    }

    /**
     * Get totaleCommande
     *
     * @return float
     */
    public function getTotaleCommande()
    {
        return $this->totaleCommande;
    }

    /**
     * Set valide
     *
     * @param boolean $valide
     *
     * @return Commande
     */
    public function setValide($valide)
    {
        $this->valide = $valide;

        return $this;
    }

    /**
     * Get valide
     *
     * @return bool
     */
    public function getValide()
    {
        return $this->valide;
    }

    /**
     * Set status
     *
     * @param string $status
     *
     * @return Commande
     */
    public function setStatus($status)
    {
        $this->status = $status;

        return $this;
    }

    /**
     * Get status
     *
     * @return string
     */
    public function getStatus()
    {
        return $this->status;
    }
}

