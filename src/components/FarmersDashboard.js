import React, { useState } from 'react';
import { Bar, BarChart, CartesianGrid, Legend, ResponsiveContainer, Tooltip, XAxis, YAxis } from 'recharts';
import './FarmersDashboard.css';
import indianStates from './data/statesAndDistricts'; // Update this line

const FarmersDashboard = () => {
  // State for selected state and district
  const [selectedState, setSelectedState] = useState('');
  const [selectedDistrict, setSelectedDistrict] = useState('');

  // Sample data for the chart
  const data = [
    { name: 'Orman-01', farmerCount: 400 },
    { name: 'Orman-02', farmerCount: 500 },
    { name: 'Orman-03', farmerCount: 600 },
  ];

  // Handle state selection change
  const handleStateChange = (e) => {
    setSelectedState(e.target.value);
    setSelectedDistrict(''); // Reset district when state changes
  };

  // Handle district selection change
  const handleDistrictChange = (e) => {
    setSelectedDistrict(e.target.value);
  };

  // Find districts based on selected state
  const districts = indianStates.find(state => state.name === selectedState)?.districts || [];

  return (
    <div className="container">
      <h1 className="title">Farmers Under Jurisdiction</h1>
      <div className="filters">
        <select value={selectedState} onChange={handleStateChange} className="state-dropdown">
          <option value="">Select State</option>
          {indianStates.map((state) => (
            <option key={state.name} value={state.name}>
              {state.name}
            </option>
          ))}
        </select>

        <select value={selectedDistrict} onChange={handleDistrictChange} className="district-dropdown" disabled={!selectedState}>
          <option value="">Select District</option>
          {districts.map((district) => (
            <option key={district} value={district}>
              {district}
            </option>
          ))}
        </select>

        <input type="text" placeholder="FPO id" />
        <input type="text" placeholder="Crop id" />
        <input type="text" placeholder="Farmer id" />
        <button className="search-button">Search</button>
      </div>

      <h2 className="chart-title">Farmer Count</h2>
      <div className="chart-container">
        <ResponsiveContainer width="100%" height={300}>
          <BarChart data={data} margin={{ top: 20, right: 30, left: 20, bottom: 5 }}>
            <CartesianGrid strokeDasharray="3 3" />
            <XAxis dataKey="name" />
            <YAxis />
            <Tooltip />
            <Legend />
            <Bar dataKey="farmerCount" fill="#8B4513" barSize={40} />
          </BarChart>
        </ResponsiveContainer>
      </div>
    </div>
  );
};

export default FarmersDashboard;
