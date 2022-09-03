import React, { useContext } from "react";
import "./navbar.css";
import Image from "../../assests/images/logo.png";
import Person from "@mui/icons-material/Person";
import Search from "@mui/icons-material/Search";
import { motion } from "framer-motion";
import { ShowLogin, ShowSignup } from "../../App";
function Navbar() {
  const [showLogin, setShowLogin] = useContext(ShowLogin);
  const [showSignup, setShowSignup] = useContext(ShowSignup);
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
            transition: {
              duration: 0.4,
            },
          }}
        />
        <div className="navbarSearchIcon">
          <Search></Search>
        </div>
      </div>
      <div className="navbarLinks">
          <div className="navLink">Categories</div>
        <div className="navLink">Write</div>
        <div
          className="navLink"
          onClick={() => {
            setShowSignup(false);
            setShowLogin(true);
          }}
        >
          Sign in
        </div>
        <div
          className="navLink"
          onClick={() => {
            setShowLogin(false);
            setShowSignup(true);
          }}
        >
          Sign up
        </div>
        <div className="navLink">
          <Person></Person>
        </div>
      </div>
    </div>
  );
}

export default Navbar;
