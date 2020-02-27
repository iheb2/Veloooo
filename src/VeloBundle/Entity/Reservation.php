<?php

namespace ProjBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Reservation
 *
 * @ORM\Table(name="reservation")
 * @ORM\Entity(repositoryClass="ProjBundle\Repository\ReservationRepository")
 */
class Reservation
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
     * @ORM\Column(name="datereservation", type="date")
     */
    private $datereservation;

    /**
     * @var int
     *
     * @ORM\Column(name="idcour", type="integer")
     */

    /**
     * @ORM\ManyToOne(targetEntity="ProjBundle\Entity\Cours")
     */
    private $idcour;

    /**
     * @var int
     *
     * @ORM\Column(name="iduser", type="integer")
     */

    /**
     * @ORM\ManyToOne(targetEntity="ProjBundle\Entity\User")
     */
    private $iduser;

    /**
     * Reservation constructor.
     * @param \DateTime $datereservation
     * @param $idcour
     * @param $iduser
     */
   /* public function __construct(\DateTime $datereservation, $idcour, $iduser)
    {
        $this->datereservation = $datereservation;
        $this->idcour = $idcour;
        $this->iduser = $iduser;
    }*/

    /**
     * Reservation constructor.
     * @param \DateTime $datereservation
     */



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
     * Set datereservation
     *
     * @param \DateTime $datereservation
     *
     * @return Reservation
     */
    public function setDatereservation($datereservation)
    {
        $this->datereservation = $datereservation;

        return $this;
    }

    /**
     * Get datereservation
     *
     * @return \DateTime
     */
    public function getDatereservation()
    {
        return $this->datereservation;
    }

    /**
     * Set idcour
     *
     * @param integer $idcour
     *
     * @return Reservation
     */
    public function setIdcour($idcour)
    {
        $this->idcour = $idcour;

        return $this;
    }

    /**
     * Get idcour
     *
     * @return int
     */
    public function getIdcour()
    {
        return $this->idcour;
    }

    /**
     * Set iduser
     *
     * @param integer $iduser
     *
     * @return Reservation
     */
    public function setIduser($iduser)
    {
        $this->iduser = $iduser;

        return $this;
    }

    /**
     * Get iduser
     *
     * @return int
     */
    public function getIduser()
    {
        return $this->iduser;
    }


}

