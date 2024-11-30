import React, { useState } from "react";
import { Button, Modal, ModalBody, ModalFooter, ModalHeader, Spinner } from "reactstrap"; // Import modal and spinner components
import "./Account.css"; // Custom CSS for styling

function Account() {
  const initialFormData = {
    firstName: "",
    lastName: "",
    email: "",
    phone: "",
    companyName: "",
    country: "",
    password: ""
  };

  const [formData, setFormData] = useState({
    firstName: "Amit",
    lastName: "Rai",
    email: "amit.rai@example.com",
    phone: "+91-787-555-2264",
    companyName: "Casa Blanca Estate",
    country: "India",
    password: "********",
  });

  const [isEditable, setIsEditable] = useState(false); // Control for edit state
  const [isSubmitting, setIsSubmitting] = useState(false); // Spinner control
  const [isModalOpen, setIsModalOpen] = useState(false); // Modal control
  const [submittedData, setSubmittedData] = useState(null); // Store submitted data

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value
    });
  };

  const handleEdit = () => {
    setIsEditable(!isEditable); // Toggle edit mode on button click
  };

  const handleAdd = () => {
    alert("Add button clicked!");
    // Add logic here
  };

  const handleDelete = () => {
    setFormData(initialFormData); // Reset form data to empty state
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setIsSubmitting(true); // Show spinner
    // Simulate API request
    setTimeout(() => {
      setSubmittedData(formData); // Set submitted data
      setIsSubmitting(false); // Hide spinner
      setIsModalOpen(true); // Open modal
    }, 2000); // Simulate a 2-second delay
  };

  const toggleModal = () => setIsModalOpen(!isModalOpen); // Toggle modal open/close

  return (
    <div className="form-container">
      <h2 style={{ textAlign: "center" }}>Welcome to Grow-Sphere</h2>
      <h5 style={{ textAlign: "center" }}>Please fill your details and get your account !!</h5>

      <form onSubmit={handleSubmit}>
        {/* First Name */}
        <div className="form-row">
          <label>First Name *</label>
          <input
            type="text"
            name="firstName"
            value={formData.firstName}
            onChange={handleChange}
            readOnly={!isEditable}
            placeholder="Enter your first name"
          />
        </div>

        {/* Last Name */}
        <div className="form-row">
          <label>Last Name *</label>
          <input
            type="text"
            name="lastName"
            value={formData.lastName}
            onChange={handleChange}
            readOnly={!isEditable}
            placeholder="Enter your last name"
          />
        </div>

        {/* Email */}
        <div className="form-row">
          <label>Email *</label>
          <input
            type="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            readOnly={!isEditable}
            placeholder="This will be your username"
          />
        </div>

        {/* Phone */}
        <div className="form-row">
          <label>Phone *</label>
          <input
            type="text"
            name="phone"
            value={formData.phone}
            onChange={handleChange}
            readOnly={!isEditable}
            placeholder="+91-787-555-2264"
          />
        </div>

        {/* Company Name */}
        <div className="form-row">
          <label>Company Name *</label>
          <input
            type="text"
            name="companyName"
            value={formData.companyName}
            onChange={handleChange}
            readOnly={!isEditable}
            placeholder="Enter your company name"
          />
        </div>

        {/* Country */}
        <div className="form-row">
          <label>Country *</label>
          <select
            name="country"
            value={formData.country}
            onChange={handleChange}
            disabled={!isEditable}
          >
            <option value="India">India</option>
            <option value="USA">USA</option>
            <option value="Australia">Australia</option>
            <option value="UK">UK</option>
          </select>
        </div>

        {/* Password */}
        <div className="form-row">
          <label>Password *</label>
          <input
            type="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            readOnly={!isEditable}
            placeholder="********"
          />
        </div>

        {/* Button Row */}
        <div className="button-row">
          <button type="button" onClick={handleAdd}>Add</button>
          <button type="button" onClick={handleEdit}>{isEditable ? "Save" : "Edit"}</button>
          <button type="button" onClick={handleDelete}>Delete</button>
          <button type="submit" disabled={isSubmitting}>
            {isSubmitting ? <Spinner size="sm" /> : "Submit"}
          </button>
        </div>
      </form>

      {/* Modal to show submitted data */}
      <Modal isOpen={isModalOpen} toggle={toggleModal}>
        <ModalHeader toggle={toggleModal}>Submitted Data</ModalHeader>
        <ModalBody>
          {submittedData ? (
            <div>
              <p>First Name: {submittedData.firstName}</p>
              <p>Last Name: {submittedData.lastName}</p>
              <p>Email: {submittedData.email}</p>
              <p>Phone: {submittedData.phone}</p>
              <p>Company Name: {submittedData.companyName}</p>
              <p>Country: {submittedData.country}</p>
              <p>Password: {submittedData.password}</p>
            </div>
          ) : (
            <p>No data submitted.</p>
          )}
        </ModalBody>
        <ModalFooter>
          <Button color="secondary" onClick={toggleModal}>Close</Button>
        </ModalFooter>
      </Modal>
    </div>
  );
}

export default Account;
