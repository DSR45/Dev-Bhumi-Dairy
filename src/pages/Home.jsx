import React from 'react';
import Products from '../components/Products';
import heroImage from '../assets/main-1.png';

const Home = () => {
  return (
    <main className="bg-gray-50 min-h-[calc(100vh-4rem)] m-0 p-0">
      <section
        className="h-[80vh] bg-cover bg-center relative flex items-center"
        style={{
          backgroundImage: `url(${heroImage})`,
          backgroundAttachment: 'fixed',
        }}
      >
        <div className="absolute inset-0 bg-black/40" />
        <div className="container relative z-10 text-blue text-center">
          <p className="text-sm font-semibold uppercase tracking-widest">100% farm fresh dairy</p>
          <h1 className="mt-4 text-3xl md:text-5xl font-extrabold">Dev Bhumi Dairy</h1>
          <p className="mt-3 text-base md:text-lg max-w-2xl mx-auto">
            Pure, trusted dairy products direct from local farms to your home.
          </p>
        </div>
      </section>

      <Products />

      <section className="container py-16">
        <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
          <div className="bg-white rounded-xl p-6 shadow-sm hover:shadow-lg transition-shadow">
            <h4 className="text-xl font-bold text-brand">Trusted Ingredients</h4>
            <p className="mt-2 text-gray-600">Sourced directly from partner farmers and quality-checked daily.</p>
            
          </div>
          
          <div className="bg-white rounded-xl p-6 shadow-sm hover:shadow-lg transition-shadow">
            <h4 className="text-xl font-bold text-brand">Pure Manufacturing</h4>
            <p className="mt-2 text-gray-600">Modern processing ensuring hygiene and superior shelf life.</p>
          </div>
          <div className="bg-white rounded-xl p-6 shadow-sm hover:shadow-lg transition-shadow">
            <h4 className="text-xl font-bold text-brand">Affordable Nutrition</h4>
            <p className="mt-2 text-gray-600">Every household can enjoy rich dairy at competitive prices.</p>
          </div>
        </div>
      </section>
    </main>
  );
};

export default Home;
