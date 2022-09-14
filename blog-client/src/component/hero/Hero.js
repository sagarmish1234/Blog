import React from 'react'
import "./hero.css"
import Image from "../../assests/images/hero-background.webp"
import Person from "../../assests/images/hero-person.webp"
function Hero() {
  return (
    <div className='heroContainer'>
        <img src={Image} alt="" className='heroBackgroundImage'/>
        <div className="heroImageOverlay"></div>
        <div className="heroTitle">WRITE <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; FOR THE <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; CHANGE</div>
        <img src={Person} alt="" className="heroPersonImage" />
    </div>
  )
}

export default Hero