
import { useEffect, useState } from 'react';
import './App.css';
import ChallengeList from './components/ChallengeList'
import axios from 'axios';
import AddChallenge from './components/AddChallenge';
import 'bootstrap/dist/css/bootstrap.min.css';



function App() {
  const [Challenges, setChallenges] = useState([]);

  useEffect(() => {
    fetchChallenges();
  }, []);

  const fetchChallenges = async () => {
    try {
      const response = await axios.get(`${process.env.REACT_APP_API_BASE_URL}/challenges`);
      setChallenges(response.data);

    } catch (error) {
      console.error("Error fetching challenges: ", error);
    }
  };

  const handleChallengeAdded = () => {
    fetchChallenges();
  };

  return (
    <div className="container mt-5">
      <h1 className="text-center mb-4">Monthly Challenges 🔥🔥</h1>
      <AddChallenge onChallengeAdded={handleChallengeAdded} />
      <ChallengeList Challenges={Challenges} />
    </div>
  );
}

export default App;
