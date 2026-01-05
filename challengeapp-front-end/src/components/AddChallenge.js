import axios from "axios";
import { useState } from "react";

function AddChallenge({ onChallengeAdded }) {
    const [month,setMonth] = useState('');
    const [description,setDescription] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await axios.post('http://localhost:8080/challenges',{month,description});
            setMonth('');
            setDescription('');
            onChallengeAdded();
        } catch (error) {
            console.error("Error Adding challenges: ", error);
        }
    };

    return(
        <div className="card my-5">
            <div class="card-header">
                Add New Challenge To Check Your Progress
            </div>
            <div className="card-body">
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="month" className="form-label">Month</label>
                    <input type="text" className="form-control" id="month" placeholder="month e.g.January" value={month} onChange={(e) => setMonth(e.target.value)} required></input>
                </div>
                <div className="mb-3">
                    <label htmlFor="description" className="form-label">Description</label>
                    <textarea className="form-control" id="description" placeholder="Description e.g.I Will Complete My HomeWork" value={description} onChange={(e) => setDescription(e.target.value)} required></textarea>
                </div>
                <button type="submit" className="btn btn-primary">Submit</button>
            </form>
            </div>
        </div>
    );
}

export default AddChallenge;