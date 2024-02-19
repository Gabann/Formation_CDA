let nameList: string[] = ['Eda', 'Raine', 'King']

export const TestComponent = () => {
    return (
        <div>
            <ul>
                {nameList.map((name) =>
                    <li key={name}>
                        {name}
                    </li>)}
            </ul>

            <button type="button" className="btn btn-primary">
                Primary
            </button>
        </div>
    );
};