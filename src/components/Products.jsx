import React from 'react';

import products from '../data/products';



const Products = () => {
  return (
    <section className="container text-center py-16 md:py-24">
      <h2 className="mt-0 text-3xl md:text-5xl font-extrabold text-gray-900">Products Range</h2>
      <p className="mt-2 text-lg text-gray-600 max-w-2xl mx-auto">
        Explore our curated dairy products made for daily nutrition and taste.
      </p>
      <div className="mt-8 grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-4">
        {products.map((item) => (
          <article key={item.name} className="rounded-xl border border-gray-200 p-6 bg-white shadow-sm hover:shadow-lg transition-shadow">
            <img src={item.icon} alt={item.name} className="h-20 w-20 mx-auto mb-4 object-contain" />
            <h3 className="text-xl font-semibold">{item.name}</h3>
            <p className="mt-2 text-gray-600">{item.desc}</p>
            <p className="mt-4 font-bold text-gray-900">{item.price}</p>
          </article>
        ))}
      </div>
    </section>
  );
};

export default Products;
