import React from "react";
import "./navbar.css";
import Image from "../../assests/images/logo.png";
import Person from "@mui/icons-material/Person";
import Search from "@mui/icons-material/Search";
import { motion } from "framer-motion";
function Navbar() {
  return (
    <div className="navbarContainer">
      <div className="navbarBrand">
        <img className="navbarBrandLogo" src={Image} />
        <div className="navbarBrandTitle">Skrive</div>
      </div>

      <div className="navbarSearch">
        <motion.input
          type="text"
          placeholder="Search for articles"
          className="navbarSearchBox"
          whileFocus={{
            width: "450px",
          }}
        />
        <div
          className="navbarSearchIcon"
        >
          <Search></Search>
        </div>
      </div>
      <div className="navbarLinks">
        <div className="navLink">Categories</div>
        <div className="navLink">Write</div>
        <div className="navLink">Sign in</div>
        <div className="navLink">Sign up</div>
        <div className="navLink">
          <Person></Person>
        </div>
      </div>
    </div>
  );
}

export default Navbar;
