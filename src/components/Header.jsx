import React, { useState, useEffect } from 'react';
import { NavLink, useLocation } from 'react-router-dom';
import { HiMenu } from 'react-icons/hi';
import Navbar from './Navbar';
import logoImage from '../assets/logo.png';

import { ImCancelCircle } from 'react-icons/im';

const Header = () => {
  const [isScrolled, setIsScrolled] = useState(false);
  const location = useLocation();
  const isHome = location.pathname === '/';
  const [showList,setShowList]=useState(false);

  useEffect(() => {
    const onScroll = () => {
      setIsScrolled(window.scrollY > 20);
    };

    window.addEventListener('scroll', onScroll);
    onScroll();

    return () => window.removeEventListener('scroll', onScroll);
  }, []);

  const headerBg = isHome 
    ? (isScrolled ? 'bg-white/95 backdrop-blur-sm shadow-sm' : 'bg-transparent')
    : 'bg-white/95 backdrop-blur-sm shadow-sm';

  const textColor = isHome
    ? (isScrolled ? 'text-gray-900' : 'text-white')
    : 'text-gray-900';

const menuLinks = [
  { name: 'Home', path: '/' },
  { name: 'About', path: '/about' },
  { name: 'Contact', path: '/contact' },
];
    const NavDropDown=()=>{
    
    return <>
    <div className=' flex justify-between touch-none z-200 absolute top-0 border-2 min-h-[100vh] min-w-[50vw] right-0 bg-[#a1d980]'>
        
        
        <nav className=' flex flex-col h-[50vh]   gap-3'>
            {menuLinks.map((item)=>{
              return  <NavLink 
                        onClick={()=>{setShowList(false)}}
                        key={item.path}
                        to={item.path}
                        className={({ isActive }) =>
                          `transition-colors duration-200 shadow-xl m-5 ${isActive ? 'underline text-brand' : 'hover:text-brand'}`
                        }
                        end={item.path === '/'}
                      >
                        {item.name}
                      </NavLink>

            })}
        </nav>
        <ImCancelCircle className=' m-5 size-7' onClick={()=>{setShowList(false)}} />
    </div>
    </>}

  return (
    <header className={`w-full fixed top-0 z-50 transition-all duration-300 ${headerBg}`}>
      <div className="container flex items-center justify-between h-20">
        <div className="flex items-center gap-3">
          <img src={logoImage} alt="Dev Bhumi Dairy Logo" className="h-20 bg-white" />
          <span className={`text-xl font-bold tracking-tight transition-colors duration-300 ${textColor}`}>
            Dev Bhumi Dairy
          </span>
        </div>
        <div className="flex items-center gap-4">
          <Navbar isScrolled={isHome ? isScrolled : true} />
          <div className="md:hidden">
            <HiMenu size={24} className={`transition-colors duration-300 ${textColor}`} onClick={()=>{setShowList((prev)=>!prev)}}/>
          </div>
        </div>
      </div>
      {showList?<NavDropDown/>:null}
    </header>
  );
};

export default Header;
