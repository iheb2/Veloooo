<?php

namespace AccessoiresBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Panier
 *
 * @ORM\Table(name="panier")
 * @ORM\Entity(repositoryClass="AccessoiresBundle\Repository\PanierRepository")
 */
class Panier
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
     * @ORM\OneToMany(targetEntity="AccessoiresBundle\Entity\PanierAccessoires", mappedBy="panier")
     */
    private $accessoires;

    /**
     * @ORM\OneToOne(targetEntity="UserBundle\Entity\User", inversedBy="panier")
     */
    private $user;

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
     * @return mixed
     */
    public function getAccessoires()
    {
        return $this->accessoires;
    }

    /**
     * @param mixed $accessoires
     */
    public function setAccessoires($accessoires)
    {
        $this->accessoires = $accessoires;
    }

    /**
     * @return mixed
     */
    public function getUser()
    {
        return $this->user;
    }

    /**
     * @param mixed $user
     */
    public function setUser($user)
    {
        $this->user = $user;
    }

    public function addAccessoires(PanierAccessoires $panierAccessoires)
    {
        if ($this->accessoires !== null)
        {
            if (!$this->accessoires->contains($panierAccessoires)) {
                $this->accessoires[] = $panierAccessoires;
            }
        }
        else
        {
            $this->accessoires[] = $panierAccessoires;
        }

        return $this;
    }

    public function removeAccessoires(PanierAccessoires $panierAccessoires)
    {
        if ($this->accessoires->contains($panierAccessoires)) {
            $this->accessoires->removeElement($panierAccessoires);
        }

        return $this;
    }
}

