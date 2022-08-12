import React from 'react'
import "./home.css"
import Image from "../../assests/images/dark-image.webp"
function Home() {
  return (
    <div className='homeContainer'>
            <img src={Image} className="homePageImage" />
    </div>
  )
}

export default Home