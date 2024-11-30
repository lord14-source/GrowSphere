import axios from 'axios'; // Import axios
import React, { useEffect, useState } from 'react';
import { NavLink } from 'react-router-dom';
import {
  Bar,
  BarChart,
  CartesianGrid,
  Legend,
  ResponsiveContainer,
  Tooltip,
  XAxis,
  YAxis,
} from 'recharts';
import './Land.css';

// List of Indian states and Jharkhand districts
const indianStates = ["Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", /*...*/ ];
const jharkhandDistricts = ["Bokaro", "Chatra", "Deoghar", "Dhanbad", /*...*/ ];

const Land = () => {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [selectedState, setSelectedState] = useState(''); 
  const [selectedDistrict, setSelectedDistrict] = useState('');

  // Fetch data from backend
  useEffect(() => {
    const fetchData = async () => {
      try {
        setLoading(true);
        const response = await axios.get('http://localhost:8080/growSphere/land-data'); // Replace with your actual API URL
        setData(response.data); // Assume response.data contains your chart data
        setLoading(false);
      } catch (error) {
        console.error('Error fetching data:', error);
        setLoading(false);
      }
    };
    
    fetchData();
  }, []); // Fetch when component loads

  const handleStateChange = (e) => {
    setSelectedState(e.target.value);
    setSelectedDistrict('');
  };

  const handleDistrictChange = (e) => {
    setSelectedDistrict(e.target.value);
  };
  

  return (
    <div className="dashboard-container">
      <div className="search-container">
        <input type="text" placeholder="Orma_00001" className="search-input" />
        
        <button className="search-button">Search</button>
      </div>

      <div className="filters-container">
        <select value={selectedState} onChange={handleStateChange} className="state-dropdown">
          <option value="">Select State</option>
          {indianStates.map((state) => (
            <option key={state} value={state}>{state}</option>
          ))}
        </select>

        {selectedState === 'Jharkhand' && (
          <select value={selectedDistrict} onChange={handleDistrictChange} className="district-dropdown">
            <option value="">Select District</option>
            {jharkhandDistricts.map((district) => (
              <option key={district} value={district}>{district}</option>
            ))}
          </select>
        )}

        <input type="text" placeholder="FPO id" />
        <input type="text" placeholder="Crop id" />
        <input type="text" placeholder="Farmer id" />
      </div>

      <div className="chart-container">
        <h3>Land Under Jurisdiction</h3>
        {loading ? (
          <p>Loading data...</p>
        ) : (
          <ResponsiveContainer width="100%" height={300}>
            <BarChart data={data} margin={{ top: 100, right: 30, left: 20, bottom: 5 }}>
              <CartesianGrid strokeDasharray="3 3" />
              <XAxis dataKey="name" />
              <YAxis />
              <Tooltip />
              <Legend />
              <Bar dataKey="quantity" fill="#8B4513" barSize={40} />
            </BarChart>
          </ResponsiveContainer>
        )}
      </div>

      <div className="redirect-link">
        <NavLink to="/about">Go to Home Page</NavLink>
      </div>
    </div>
  );
};

export default Land;
