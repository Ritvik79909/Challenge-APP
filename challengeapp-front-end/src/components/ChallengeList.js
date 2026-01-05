import Challenge from "./Challenge";

function ChallengeList({Challenges}) {
    return(
        <div className="list-group">
            {Challenges.map(challenge => (
                
                <Challenge key={challenge.id}
                challenge={challenge}/>
                
            ))}
        </div>
    );
}

export default ChallengeList;