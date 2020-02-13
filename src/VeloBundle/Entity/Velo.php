<?php

namespace VeloBundle\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;
/**
 * Velo
 *
 * @ORM\Table(name="velo")
 * @ORM\Entity(repositoryClass="VeloBundle\Repository\VeloRepository")
 */
;class Velo
{

    /**
     * @ORM\ManyToMany(targetEntity="commande", inversedBy="velos", cascade={"persist"})
     * @ORM\JoinTable(
     *     name="passer",
     *     joinColumns={
     *          @ORM\JoinColumn(name="id_velo", referencedColumnName="id")
     *     },
     *     inverseJoinColumns={
     *          @ORM\JoinColumn(name="id_commande", referencedColumnName="id")
     *     }
     * )
     */
    private  $commandes;


    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="nom", type="string", length=255)
     */
    private $nom;

    /**
     * @var float
     *
     * @ORM\Column(name="prixachat", type="float")
     * @Assert\GreaterThan(
     *     value=0
     * )
     */
    private $prixachat;

    /**
     * @var float
     *
     * @ORM\Column(name="prixvente", type="float")
     *
     * @Assert\GreaterThan(
     *     value=0
     * )
     */
    private $prixvente;

    /**
     * @var int
     *
     * @ORM\Column(name="quantite", type="integer")
     * @Assert\GreaterThan(
     *     value=0
     * )
     */
    private $quantite;

    /**
     * @var string
     *
     * @ORM\Column(name="description", type="string", length=255)
     *
     */
    private $description;
















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
     * Set nom
     *
     * @param string $nom
     *
     * @return Velo
     */
    public function setNom($nom)
    {
        $this->nom = $nom;

        return $this;
    }

    /**
     * Get nom
     *
     * @return string
     */
    public function getNom()
    {
        return $this->nom;
    }

    /**
     * Set prixachat
     *
     * @param float $prixachat
     *
     * @return Velo
     */
    public function setPrixachat($prixachat)
    {
        $this->prixachat = $prixachat;

        return $this;
    }

    /**
     * Get prixachat
     *
     * @return float
     */
    public function getPrixachat()
    {
        return $this->prixachat;
    }

    /**
     * Set prixvente
     *
     * @param float $prixvente
     *
     * @return Velo
     */
    public function setPrixvente($prixvente)
    {
        $this->prixvente = $prixvente;

        return $this;
    }

    /**
     * Get prixvente
     *
     * @return float
     */
    public function getPrixvente()
    {
        return $this->prixvente;
    }

    /**
     * Set quantite
     *
     * @param integer $quantite
     *
     * @return Velo
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
     * Set description
     *
     * @param string $description
     *
     * @return Velo
     */
    public function setDescription($description)
    {
        $this->description = $description;

        return $this;
    }

    /**
     * Get description
     *
     * @return string
     */
    public function getDescription()
    {
        return $this->description;
    }


    /**
     * @return mixed
     */
    public function getPanier()
    {
        return $this->Panier;
    }

    /**
     * @param mixed $Panier
     */
    public function setPanier($Panier)
    {
        $this->Panier = $Panier;
    }

}

