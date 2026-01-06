function Challenge({ challenge }) {
    return (
        // eslint-disable-next-line jsx-a11y/anchor-is-valid
        <a href="#" className="list-group-item list-group-item-action" aria-current="true">
            <div className="d-flex w-100 justify-content-between">
                <h4 className="mb-1">{challenge.month}</h4>
                <small>{challenge.id}</small>
            </div>
            <p className="mb-1">{challenge.description}</p>
        </a>
    );
}

export default Challenge;