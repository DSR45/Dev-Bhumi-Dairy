import React from 'react';
import { NavLink } from 'react-router-dom';

const menuLinks = [
  { name: 'Home', path: '/' },
  { name: 'About', path: '/about' },
  { name: 'Contact', path: '/contact' },
];

const Navbar = ({ isScrolled }) => {
  return (
    <nav className=" hidden md:flex items-center gap-8 text-sm font-medium">
      {menuLinks.map((item) => (
        <NavLink
          key={item.path}
          to={item.path}
          className={({ isActive }) =>
            `transition-colors duration-200 ${isActive ? 'underline text-brand' : 'hover:text-brand'} ${isScrolled ? 'text-gray-700' : 'text-white'}`
          }
          end={item.path === '/'}
        >
          {item.name}
        </NavLink>
      ))}
    </nav>
  );
};

export default Navbar;
