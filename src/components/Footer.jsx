import React from 'react';
import { NavLink } from 'react-router-dom';

const Footer = () => {
  return (
    <footer className="w-full bg-gray-900 text-gray-100 pt-12 pb-6">
      <div className="container grid gap-8 md:grid-cols-4">
        <div>
          <h4 className="text-lg font-bold mb-3">Dev Bhumi Dairy</h4>
          <p className="text-gray-300">Premium dairy products with farm-to-home freshness.</p>
        </div>

        <div>
          <h4 className="text-lg font-bold mb-3">Products</h4>
          <ul className="space-y-2 text-gray-300">
            <li><NavLink to="/" className="hover:text-white">Milk</NavLink></li>
            <li><NavLink to="/" className="hover:text-white">Paneer</NavLink></li>
            <li><NavLink to="/" className="hover:text-white">Curd</NavLink></li>
          </ul>
        </div>

        <div>
          <h4 className="text-lg font-bold mb-3">Company</h4>
          <ul className="space-y-2 text-gray-300">
            <li><NavLink to="/about" className="hover:text-white">About Us</NavLink></li>
            <li><NavLink to="/contact" className="hover:text-white">Contact</NavLink></li>
          </ul>
        </div>

        <div>
          <h4 className="text-lg font-bold mb-3">Contact</h4>
          <p className="text-gray-300">devbhumi.pilibhit@gmail.com</p>
          <p className="text-gray-300">+91 9719820086</p>
        </div>
      </div>

      <div className="container mt-8 border-t border-gray-800 pt-4 text-center text-gray-400 text-sm">
        © {new Date().getFullYear()} Dev Bhumi Dairy. All rights reserved.
      </div>
    </footer>
  );
};

export default Footer;
