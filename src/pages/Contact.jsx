import React from 'react';

const Contact = () => {
  return (
    <main className="pt-24 container py-16">
      <h2 className="text-4xl font-extrabold text-gray-900">Contact Us</h2>
      <p className="mt-4 text-gray-600 max-w-3xl">Questions, wholesale inquiries or delivery requests? We are here to help.</p>

      <div className="mt-10 grid grid-cols-1 md:grid-cols-2 gap-10">
        <div className="bg-white rounded-xl p-6 shadow-sm">
          <h3 className="text-2xl font-bold text-brand">Reach out</h3>
          <p className="mt-2 text-gray-600">Email: devbhumi.pilibhit@gmail.com</p>
          <p className="mt-1 text-gray-600">Phone: +91 9719820086</p>
          <p className="mt-1 text-gray-600">Address: Dev Bhumi Dairy,Barkhera,pilibhit,Uttarpradesh, India</p>
        </div>
        
      </div>
    </main>
  );
};

export default Contact;
