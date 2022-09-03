import React, { useContext, useState } from "react";
import "./login.css";
import Image from "../../assests/images/login-image.jpeg";
import Person from "@mui/icons-material/Person";
import RemoveRedEyeSharp from "@mui/icons-material/RemoveRedEyeSharp";
import VisibilityOffSharp from "@mui/icons-material/VisibilityOffSharp";
import ArrowBackSharp from "@mui/icons-material/ArrowBackSharp";
import { UserDetails } from "../../App";
import { motion } from "framer-motion";
import FormError from "../formError/FormError";
import { HashLoader } from "react-spinners";
import baseUrl from "../../config/BaseUrl";
import axios from "axios";
import { useLocation, useNavigate, Link } from "react-router-dom";

function Login() {
  const [showPassword, setShowPassword] = useState(false);
  const [showError, setShowError] = useState(false);
  const [userDetails, setUserDetails] = useContext(UserDetails);
  const location = useLocation();
  const navigate = useNavigate();
  const [userForm, setUserForm] = useState({
    username: "",
    password: "",
  });
  const [message, setMessage] = useState("Default");
  const [theme, setTheme] = useState("None");
  const [loading, setLoading] = useState(false);
  const handleShowPassword = () => {
    setShowPassword(!showPassword);
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setUserForm({ ...userForm, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    try {
      const response = await axios.post(`${baseUrl}/user/login`, userForm);
      sessionStorage.setItem("userDetails", JSON.stringify(response.data.user));
      sessionStorage.setItem("token", JSON.stringify(response.data.token));
      setUserDetails(response.data.user);
      navigate(location.state?.from || "/")
      setLoading(false);
    } catch ({ response }) {
      setMessage(response.data.message);
      setTheme("loginError");
      setShowError(true);
      setLoading(false);
    }
  };

  return (
    <motion.div
      className="loginBackground"
      initial={{ opacity: 0 }}
      animate={{
        opacity: 1,
        transition: {
          duration: 0.2,
        },
      }}
      exit={{
        opacity: 0,
        transition: {
          duration: 0.2,
        },
      }}
    >
      <div className="loginForm">
        {loading && (
          <div className="loginLoading">
            <HashLoader
              color="#002db3"
              loading={loading}
              size={100}
            ></HashLoader>
          </div>
        )}
        {!loading && (
          <form className="loginFormInputs" onSubmit={handleSubmit}>
            <div className="loginBack">
              <ArrowBackSharp
                style={{ fontSize: "1.7rem", cursor: "pointer" }}
                onClick={() => navigate("/")}
              ></ArrowBackSharp>
            </div>
            <div className="loginFormHeader">
              <div className="loginFormTitle">Welcome Back</div>
              <div className="loginFormSubHeading">
                Please login to your account to dive deep inside
              </div>
            </div>
            <div className="loginFormInput">
              <input
                type="text"
                name="username"
                className="loginInput"
                placeholder="Email"
                required={true}
                value={userForm.username}
                onChange={handleChange}
              />
              <Person></Person>
            </div>
            <div className="loginFormInput">
              <input
                type={showPassword ? "text" : "password"}
                name="password"
                className="loginInput"
                spellCheck={false}
                placeholder="Password"
                required={true}
                value={userForm.password}
                onChange={handleChange}
              />
              {showPassword ? (
                <RemoveRedEyeSharp
                  onClick={handleShowPassword}
                  style={{ cursor: "pointer" }}
                />
              ) : (
                <VisibilityOffSharp
                  onClick={handleShowPassword}
                  style={{ cursor: "pointer" }}
                />
              )}
            </div>
            <div className="loginFormSubmit">
              <button className="loginFormButton" type="submit">
                Dive Deep
              </button>
            </div>
            {showError && (
              <FormError theme={theme} message={message}></FormError>
            )}
            <div className="loginFormSignUp">
              Don't have an account?{" "}
              <Link to={"/register"} style={{textDecoration:"none"}}>
                <span
                  
                  style={{
                    cursor: "pointer",
                    color: "blue",
                    fontWeight: "600",
                    fontSize: "1.1rem",
                  }}
                >
                  Signup
                </span>
              </Link>
            </div>
          </form>
        )}
        <img src={Image} alt="img" className="loginImage" />
      </div>
    </motion.div>
  );
}

export default Login;
