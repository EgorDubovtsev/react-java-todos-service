import styled from 'styled-components';

const TodoName = styled.div`
    background: red;
    text-align:center;
    margin-top: 10px;
`;
const TodoProp = styled.div`
    text-align:center;
    margin-top: 10px;
`;

const TodoBody = styled.div`
    display:flex;
    flex-direction: column;
    justify-content: center;
    font-size: 22px;
     padding: 10px;
    width: 200px;
    border-radious:15px;
    background: #8AC144;
    margin-top: 20px;
    border: 3px solid #4C3190;

`;
export default function Todo(props) {

    return (
        <TodoBody>
            <TodoName>{props.todo.id}</TodoName>
            <TodoProp>{props.todo.title}</TodoProp>
            <TodoProp>{props.todo.isCompleted ? "completed" : "not ready"}</TodoProp>
        </TodoBody>
    )
}