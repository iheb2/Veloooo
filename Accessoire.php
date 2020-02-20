<?php

namespace AccessoiresBundle\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\HttpFoundation\File\UploadedFile;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * Accessoire
 *
 * @ORM\Table(name="accessoire")
 * @ORM\Entity(repositoryClass="AccessoiresBundle\Repository\AccessoireRepository")
 * @ORM\HasLifecycleCallbacks()
 */
class Accessoire
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
     * @var string
     *
     * @ORM\Column(name="name", type="string", length=255, nullable=true)
     *
     * @Assert\NotBlank(message="name Obligatoire")
     *
     */
    private $name;

    /**
     * @var int
     *
     * @ORM\Column(name="quantite", type="integer", nullable=true)
     * @Assert\NotBlank(message="quantité Obligatoire")
     *  @Assert\GreaterThan(value="0")
     */
    private $quantite;

    /**
     * @var float
     *
     * @ORM\Column(name="price", type="float", nullable=true)
     * * @Assert\NotBlank(message="price Obligatoire")
     * @Assert\GreaterThan(value="0")
     */
    private $price;

    /**
     * @var string
     *
     * @ORM\Column(name="description", type="string", length=255, nullable=true)
     * @Assert\NotBlank(message="description Obligatoire")
     */
    private $description;

    /**
     * @var string
     *
     * @ORM\Column(name="modele", type="string", length=255, nullable=true)
     * @Assert\NotBlank(message="modele Obligatoire")
     */
    private $modele;

    /**
     * @ORM\OneToMany(targetEntity="AccessoiresBundle\Entity\PanierAccessoires", mappedBy="accessoire")
     */
    private $paniers;


    /**
     * @ORM\OneToOne(targetEntity="AccessoiresBundle\Entity\Promotion", mappedBy="accessoire", cascade={"persist", "remove"})
     */
    private $promotion;

    /**
     * @ORM\Column(type="string", length=255, nullable=true)
     */
    public $image;

    /**
     * @ORM\Column(type="string", length=255, nullable=true)
     */
    public $path;

    /**
     * @Assert\File(maxSize="6000000")
     */
    private $file;

    private $temp;

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
     * Set name
     *
     * @param string $name
     *
     * @return Accessoire
     */
    public function setName($name)
    {
        $this->name = $name;

        return $this;
    }

    /**
     * Get name
     *
     * @return string
     */
    public function getName()
    {
        return $this->name;
    }

    /**
     * Set quantite
     *
     * @param integer $quantite
     *
     * @return Accessoire
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
     * Set price
     *
     * @param float $price
     *
     * @return Accessoire
     */
    public function setPrice($price)
    {
        $this->price = $price;

        return $this;
    }

    /**
     * Get price
     *
     * @return float
     */
    public function getPrice()
    {
        return $this->price;
    }

    /**
     * Set description
     *
     * @param string $description
     *
     * @return Accessoire
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
     * Set modele
     *
     * @param string $modele
     *
     * @return Accessoire
     */
    public function setModele($modele)
    {
        $this->modele = $modele;

        return $this;
    }

    /**
     * Get modele
     *
     * @return string
     */
    public function getModele()
    {
        return $this->modele;
    }

    /**
     * @return mixed
     */
    public function getPaniers()
    {
        return $this->paniers;
    }

    /**
     * @param mixed $paniers
     */
    public function setPaniers($paniers)
    {
        $this->paniers = $paniers;
    }

    /**
     * @return mixed
     */
    public function getPromotion()
    {
        return $this->promotion;
    }

    /**
     * @param mixed $promotion
     */
    public function setPromotion($promotion)
    {
        $this->promotion = $promotion;
    }


    public function addPanier(PanierAccessoires $panierAccessoires)
    {
        if (!$this->paniers->contains($panierAccessoires)) {
            $this->paniers[] = $panierAccessoires;
        }

        return $this;
    }

    public function removePanier(PanierAccessoires $panierAccessoires)
    {
        if ($this->paniers->contains($panierAccessoires)) {
            $this->paniers->removeElement($panierAccessoires);
        }

        return $this;
    }
















    public function getWebPath()
    {
        return null === $this->path
            ? null
            : $this->getParameter('images_directory').'/'.$this->path;
    }

    protected function getUploadRootDir()
    {
        // the absolute directory path where uploaded
        // documents should be saved
        return $this->getParameter('images_directory');
    }


    /**
     * Sets file.
     *
     * @param UploadedFile $file
     */
    public function setFile(UploadedFile $file = null)
    {
        $this->file = $file;
        // check if we have an old image path
        if (is_file($this->getAbsolutePath())) {
            // store the old name to delete after the update
            $this->temp = $this->getAbsolutePath();
        } else {
            $this->path = 'initial';
        }
    }

    /**
     * Get file.
     *
     * @return UploadedFile
     */
    public function getFile()
    {
        return $this->file;
    }

    /**
     * @ORM\PrePersist()
     * @ORM\PreUpdate()
     */
    public function preUpload()
    {
        if (null !== $this->getFile()) {
            $this->path = $this->getFile()->guessExtension();
        }
    }
    /**
     * @ORM\PostPersist()
     * @ORM\PostUpdate()
     */
    public function upload()
    {
        if (null === $this->getFile()) {
            return;
        }

        // check if we have an old image
        if (isset($this->temp)) {
            // delete the old image
            unlink($this->temp);
            // clear the temp image path
            $this->temp = null;
        }

        // you must throw an exception here if the file cannot be moved
        // so that the entity is not persisted to the database
        // which the UploadedFile move() method does
        $this->getFile()->move(
            $this->getUploadRootDir(),
            $this->id.'.'.$this->getFile()->guessExtension()
        );

        $this->setFile(null);
    }

    /**
     * @ORM\PreRemove()
     */
    public function storeFilenameForRemove()
    {
        $this->temp = $this->getAbsolutePath();
    }

    /**
     * @ORM\PostRemove()
     */
    public function removeUpload()
    {
        if (isset($this->temp)) {
            unlink($this->temp);
        }
    }

    public function getAbsolutePath()
    {
        return null === $this->path
            ? null
            : $this->getUploadRootDir().'/'.$this->id.'.'.$this->path;
    }

    /**
     * @return mixed
     */
    public function getImage()
    {
        return $this->image;
    }

    /**
     * @param mixed $image
     */
    public function setImage($image)
    {
        $this->image = $image;
    }

    /**
     * @return mixed
     */
    public function getPath()
    {
        return $this->path;
    }

    /**
     * @param mixed $path
     */
    public function setPath($path)
    {
        $this->path = $path;
    }

    /**
     * @return mixed
     */
    public function getTemp()
    {
        return $this->temp;
    }

    /**
     * @param mixed $temp
     */
    public function setTemp($temp)
    {
        $this->temp = $temp;
    }


}

