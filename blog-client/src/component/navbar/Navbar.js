import React, { useContext } from "react";
import "./navbar.css";
import Image from "../../assests/images/logo.png";
import Person from "@mui/icons-material/Person";
import Search from "@mui/icons-material/Search";
import { motion } from "framer-motion";
import {UserDetails } from "../../App";
import { Link, useNavigate } from "react-router-dom";
function Navbar() {
  const [userDetails,setUserDetails] = useContext(UserDetails);
  const navigate = useNavigate()
  return (
    <div className="navbarContainer">
      <div className="navbarBrand" onClick={()=> navigate("/")}>
        <img className="navbarBrandLogo" src={Image} />
        <div className="navbarBrandTitle">Skrive</div>
      </div>

      {userDetails && <div className="navbarSearch">
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
      </div>}
      <div className="navbarLinks">
        <Link to="/categories" className="navLink started" style={{textDecoration:"none"}}> Get started</Link>
        <div className="navLink">Write</div>
        {!userDetails && <div
          className="navLink"
          onClick={() => {
          
            navigate("/login");
          }}
        >
          Sign in
        </div>}
        {!userDetails && <div
          className="navLink"
          onClick={() => {
            navigate("/register")
          }}
        >
          Sign up
        </div>}
        {userDetails && <div className="navLink" >
          <img src={userDetails.image} alt="img" className="navbarProfile" />
        </div>}
      </div>
    </div>
  );
}

export default Navbar;
