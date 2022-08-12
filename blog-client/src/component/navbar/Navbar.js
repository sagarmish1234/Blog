import React from "react";
import "./navbar.css";
import Image from "../../assests/images/logo.png";
function Navbar() {
  return (
    <div className="navbarContainer">
      <div className="navbarBrand">
        <img className="navbarBrandLogo" src={Image} />
        <div className="navbarBrandTitle">Skrive</div>
      </div>
      <div className="navbarLinks"></div>
    </div>
  );
}

export default Navbar;
