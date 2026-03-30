import React from 'react';

const About = () => {
  return (
    <main className="pt-24 container py-16">
      <h2 className="text-4xl font-extrabold text-gray-900">About Dev Bhumi Dairy</h2>
      <p className="mt-4 text-lg text-gray-600 max-w-3xl">
        Dev Bhumi Dairy is built on family values and the promise of purity. We deliver dairy staples to your doorstep with a commitment to freshness, quality, and fair pricing.
      </p>

      <div className="mt-10 grid grid-cols-1 md:grid-cols-2 gap-8">
        <div className="bg-white rounded-xl p-6 shadow-sm">
          <h3 className="text-2xl font-bold text-brand">Our Mission</h3>
          <p className="mt-2 text-gray-600">To make nutritious dairy products accessible to every Indian household, while empowering local farmers.</p>
        </div>
        <div className="bg-white rounded-xl p-6 shadow-sm">
          <h3 className="text-2xl font-bold text-brand">Our Values</h3>
          <ul className="mt-2 text-gray-600 list-disc list-inside space-y-1">
            <li>Clean sourcing</li>
            <li>Strict hygiene</li>
            <li>Customer trust</li>
            <li>Community growth</li>
          </ul>
        </div>
      </div>
    </main>
  );
};

export default About;
