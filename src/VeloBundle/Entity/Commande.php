<?php

namespace VeloBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Commande
 *
 * @ORM\Table(name="commande")
 * @ORM\Entity(repositoryClass="VeloBundle\Repository\CommandeRepository")
 */
class Commande
{
    /**
     * @ORM\ManyToMany(targetEntity="Velo", mappedBy="commandes",inversedBy="velos")
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
     * @var \DateTime
     *
     * @ORM\Column(name="datecommande", type="date")
     */
    private $datecommande;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="datereglement", type="date")
     */
    private $datereglement;

    /**
     * @var string
     *
     * @ORM\Column(name="moyenpaiement", type="string", length=255)
     */
    private $moyenpaiement;

    /**
     * @var float
     *
     * @ORM\Column(name="totalcommande", type="float")
     */
    private $totalcommande;

    /**
     * @var bool
     *
     * @ORM\Column(name="paiementvalide", type="boolean")
     */
    private $paiementvalide;

    /**
     * @var string
     *
     * @ORM\Column(name="statutcde", type="string", length=255)
     */
    private $statutcde;


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
     * Set datecommande
     *
     * @param \DateTime $datecommande
     *
     * @return Commande
     */
    public function setDatecommande($datecommande)
    {
        $this->datecommande = $datecommande;

        return $this;
    }

    /**
     * Get datecommande
     *
     * @return \DateTime
     */
    public function getDatecommande()
    {
        return $this->datecommande;
    }

    /**
     * Set datereglement
     *
     * @param \DateTime $datereglement
     *
     * @return Commande
     */
    public function setDatereglement($datereglement)
    {
        $this->datereglement = $datereglement;

        return $this;
    }

    /**
     * Get datereglement
     *
     * @return \DateTime
     */
    public function getDatereglement()
    {
        return $this->datereglement;
    }

    /**
     * Set moyenpaiement
     *
     * @param string $moyenpaiement
     *
     * @return Commande
     */
    public function setMoyenpaiement($moyenpaiement)
    {
        $this->moyenpaiement = $moyenpaiement;

        return $this;
    }

    /**
     * Get moyenpaiement
     *
     * @return string
     */
    public function getMoyenpaiement()
    {
        return $this->moyenpaiement;
    }

    /**
     * Set totalcommande
     *
     * @param float $totalcommande
     *
     * @return Commande
     */
    public function setTotalcommande($totalcommande)
    {
        $this->totalcommande = $totalcommande;

        return $this;
    }

    /**
     * Get totalcommande
     *
     * @return float
     */
    public function getTotalcommande()
    {
        return $this->totalcommande;
    }

    /**
     * Set paiementvalide
     *
     * @param boolean $paiementvalide
     *
     * @return Commande
     */
    public function setPaiementvalide($paiementvalide)
    {
        $this->paiementvalide = $paiementvalide;

        return $this;
    }

    /**
     * Get paiementvalide
     *
     * @return bool
     */
    public function getPaiementvalide()
    {
        return $this->paiementvalide;
    }

    /**
     * Set statutcde
     *
     * @param string $statutcde
     *
     * @return Commande
     */
    public function setStatutcde($statutcde)
    {
        $this->statutcde = $statutcde;

        return $this;
    }

    /**
     * Get statutcde
     *
     * @return string
     */
    public function getStatutcde()
    {
        return $this->statutcde;
    }
}

