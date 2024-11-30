// import React from 'react';
// import { NavLink } from 'react-router-dom';

// function About() {
//   return (
//     <div className="container">
//       {/* Sidebar */}
//       {/* <div className="sidebar">
//         <NavLink to="/dashboard" className="side-link" activeClassName={({ isActive }) => isActive ? 'active-link' : ''}>
//           Yield Forecast
//         </NavLink>
//         <NavLink to="/farmersdashboard" className="side-link" activeClassName={({ isActive }) => isActive ? 'active-link' : ''}>
//           Farmer's Under Jurisdiction
//         </NavLink>
//         <NavLink to="/land" className="side-link" activeClassName={({ isActive }) => isActive ? 'active-link' : ''}>
//           Land Under Jurisdiction
//         </NavLink>
//         <NavLink to="/about" className="side-link" activeClassName={({ isActive }) => isActive ? 'active-link' : ''}>
//           Marketing Insights
//         </NavLink>
//         <NavLink to="/stakeholder" className="side-link" activeClassName={({ isActive }) => isActive ? 'active-link' : ''}>
//           Stakeholder Management
//         </NavLink>
//         <NavLink to="/showing" className="side-link" activeClassName={({ isActive }) => isActive ? 'active-link' : ''}>
//           Farmer's Input
//         </NavLink>
//         <NavLink to="/map" className="side-link" activeClassName={({ isActive }) => isActive ? 'active-link' : ''}>
//           Map
//         </NavLink>
//         <NavLink to="/register" className="side-link" activeClassName={({ isActive }) => isActive ? 'active-link' : ''}>
//           Account User
//         </NavLink>
//       </div> */}
//       <div className="sidebar">
        
//         {/* <NavLink to="/dashboard" className={({ isActive }) => (isActive ? 'side-link active-link' : 'side-link')}>
//           Yield Forecast
//         </NavLink>
//         <NavLink to="/farmersdashboard" className={({ isActive }) => (isActive ? 'side-link active-link' : 'side-link')}>
//           Farmer's Under Jurisdiction
//         </NavLink>
//         <NavLink to="/land" className={({ isActive }) => (isActive ? 'side-link active-link' : 'side-link')}>
//           Land Under Jurisdiction
//         </NavLink>
//         <NavLink to="/about" className={({ isActive }) => (isActive ? 'side-link active-link' : 'side-link')}>
//           Marketing Insights
//         </NavLink>
//         <NavLink to="/stakeholder" className={({ isActive }) => (isActive ? 'side-link active-link' : 'side-link')}>
//           Stakeholder Management
//         </NavLink>
//         <NavLink to="/showing" className={({ isActive }) => (isActive ? 'side-link active-link' : 'side-link')}>
//           Farmer's Input
//         </NavLink>
//         <NavLink to="/map" className={({ isActive }) => (isActive ? 'side-link active-link' : 'side-link')}>
//           Map
//         </NavLink>
//         <NavLink to="/register" className={({ isActive }) => (isActive ? 'side-link active-link' : 'side-link')}>
//           Account User
//         </NavLink>
//         <NavLink to={"/home"}>he</NavLink> */}
//          <nav>
//         <NavLink to="/dashboard" className={({ isActive }) => (isActive ? 'active-link' : '')}>
//           Yield Forecast
//         </NavLink>
//         <NavLink to="/farmersdashboard" className={({ isActive }) => (isActive ? 'active-link' : '')}>
//           Farmer's Under Jurisdiction
//         </NavLink>
//         {/* Add more links as needed */}
//       </nav>
//         </div> 

//       {/* Main Content */}
//       <div className="content">
      
//         <h2 style={{textAlign:'center',marginLeft:'180px'}}>Now you can create your accont please visit account section</h2>
//         <p style={{textAlign:'center',marginLeft:'180px'}}>Welcome to the Marketing Insights section.Steps to create an account.
       
//         </p>
//         <div className="redirect-link">
//         <NavLink to="/home">Go to Home Page</NavLink> {/* NavLink for redirection */}
//       </div>
//         <p></p>
//       </div>
      
//     </div>
//   );
// }

// export default About;
import React from 'react';
import { NavLink } from 'react-router-dom';

function About() {
  return (
    <div className="container">
      <div className="sidebar">
        <nav>
          <NavLink to="/dashboard" className={({ isActive }) => (isActive ? 'active-link' : '')}>
            Yield Forecast
          </NavLink>
          <NavLink to="/farmersdashboard" className={({ isActive }) => (isActive ? 'active-link' : '')}>
            Farmer's Under Jurisdiction
          </NavLink>
          <NavLink to="/home" className={({ isActive }) => (isActive ? 'active-link' : '')}>
            Go to Home Page
          </NavLink>
        </nav>
      </div>

      <div className="content">
        <h2 style={{ textAlign: 'center', marginLeft: '180px' }}>
          Now you can create your account, please visit the account section
        </h2>
        <p style={{ textAlign: 'center', marginLeft: '180px' }}>
          Welcome to the Marketing Insights section.
        </p>
        <div className="redirect-link">
          <NavLink to="/home" className={({ isActive }) => (isActive ? 'active-link' : '')}>
            Go to Home Page
          </NavLink>
        </div>
      </div>
    </div>
  );
}

export default About;

