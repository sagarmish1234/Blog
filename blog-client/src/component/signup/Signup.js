import React, { useContext, useState } from "react";
import "./signup.css";
import axios from "axios";
import ProgressBar from "@ramonak/react-progress-bar";
import Person from "@mui/icons-material/Person";
import AlternateEmailSharp from "@mui/icons-material/AlternateEmailSharp";
import RemoveRedEyeSharp from "@mui/icons-material/RemoveRedEyeSharp";
import VisibilityOffSharp from "@mui/icons-material/VisibilityOffSharp";
import PhoneInTalkSharp from "@mui/icons-material/PhoneInTalkSharp";
import { HashLoader } from "react-spinners";
import ArrowBackSharp from "@mui/icons-material/ArrowBackSharp";
import { ShowSignup } from "../../App";
import FormError from "../formError/FormError";
import baseUrl from "../../config/BaseUrl";
import { motion } from "framer-motion";

function Signup() {
  const [showSignup, setShowSignup] = useContext(ShowSignup);
  const [signupUser, setSignupUser] = useState({
    fullName: "",
    email: "",
    image: null,
    password: "",
    confirmPassword: "",
    phone: "",
  });
  const [loading, setLoading] = useState(false);
  const [uploadProgress, setUploadProgress] = useState(null);
  const [showPassword, setShowPassword] = useState(false);
  const [message, setMessage] = useState("Default");
  const [theme, setTheme] = useState("signupError");
  const [showError, setShowError] = useState(false);
  const handleImage = async (e) => {
    var formdata = new FormData();
    formdata.append("file", e.target.files[0]);
    formdata.append("cloud_name", "sagarmish1234");
    formdata.append("upload_preset", "tutorial");
    try {
      const response = await axios.post(
        "https://api.cloudinary.com/v1_1/sagarmish1234/auto/upload",
        formdata,
        {
          mode: "cors",
          onUploadProgress: (data) => {
            console.log(Math.round((data.loaded / data.total) * 100));
            setUploadProgress(Math.round((data.loaded / data.total) * 100));
          },
        }
      );
      setSignupUser({ ...signupUser, image: response.data.secure_url });
      setUploadProgress(null);
      console.log(response);
    } catch (err) {
      console.log(err);
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (signupUser.password !== signupUser.confirmPassword) {
      setMessage("Password Mismatched");
      setTheme("signupError");
      setShowError(true);
      return;
    }
    setLoading(true);
    try {
      const response = await axios.post(`${baseUrl}/user/register`, signupUser);
      setMessage("User registered successfully");
      setTheme("signupSuccess");
      setShowError(true)
      setLoading(false);
    } catch ({ response }) {
      setMessage(response.data.message);
      setTheme("signupError");
      setShowError(true);
      setLoading(false);
    }
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setSignupUser({ ...signupUser, [name]: value });
  };
  const handleShowPassword = () => {
    setShowPassword(!showPassword);
  };
  return (
    <motion.div
      className="signupBackground"
      initial={{ opacity: 0 }}
      animate={{
        opacity: 1,
        transition: {
          duration: 0.15,
        },
      }}
      exit={{
        opacity: 0,
        transition: {
          duration: 0.15,
        },
      }}
    >
      {loading && (
        <div className="signupLoading">
          <HashLoader color="#002db3" loading={loading} size={100}></HashLoader>
        </div>
      )}
      {!loading && (
        <div className="signupForm">
          <div className="loginBack">
            <ArrowBackSharp
              style={{ fontSize: "2.3rem", cursor: "pointer" }}
              onClick={() => setShowSignup(false)}
            ></ArrowBackSharp>
          </div>
          <div className="signupFormHeader">
            <div className="signupFormTitle">Create Account</div>
            <div className="signupFormSubHeading">
              Share your thoughts with the world from today
            </div>
          </div>
          {uploadProgress && (
            <ProgressBar completed={uploadProgress} width={300} margin="20px" />
          )}
          <div className="signupUserImage">
            {signupUser.image && (
              <img
                src={signupUser.image}
                wdith={100}
                height={100}
                className="userImage"
              />
            )}
          </div>
          <form className="signupFormInputs" onSubmit={handleSubmit}>
            <label htmlFor="image" className="signupUploadButton">
              Profile Picture
            </label>
            <input
              type="file"
              name="image"
              id="image"
              onChange={handleImage}
              className="uploadButton"
              title=" "
            />
            <div className="signupFormInput">
              <input
                type="text"
                name="fullName"
                className="signupInput"
                placeholder="Fulll Name"
                required={true}
                value={signupUser.fullName}
                onChange={handleChange}
              />
              <Person></Person>
            </div>
            <div className="signupFormInput">
              <input
                type="email"
                name="email"
                className="signupInput"
                placeholder="Email"
                required={true}
                value={signupUser.email}
                onChange={handleChange}
              />
              <AlternateEmailSharp></AlternateEmailSharp>
            </div>
            <div className="signupFormInput">
              <input
                type="text"
                name="phone"
                className="signupInput"
                placeholder="Phone"
                required={true}
                value={signupUser.phone}
                onChange={handleChange}
              />
              <PhoneInTalkSharp />
            </div>
            <div className="signupFormInput">
              <input
                type={showPassword ? "text" : "password"}
                name="password"
                className="signupInput"
                spellCheck={false}
                placeholder="Password"
                required={true}
                value={signupUser.password}
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
            <div className="signupFormInput">
              <input
                type={showPassword ? "text" : "password"}
                name="confirmPassword"
                className="signupInput"
                spellCheck={false}
                placeholder="Confirm Password"
                required={true}
                value={signupUser.confirmPassword}
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
            <button type="submit" className="signupFormSubmit">
              Create Account
            </button>
          </form>
          {showError && <FormError theme={theme} message={message}></FormError>}
        </div>
      )}
    </motion.div>
  );
}

export default Signup;
