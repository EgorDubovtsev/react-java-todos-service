import { useState } from 'react';
import styled from 'styled-components'
import { fetchTodoById } from '../funcs/todos-functions';

const FetchTodoButton = styled.input`
         height: 50px;
        width: 180px;
        font-size:25px;
    `;

const Form = styled.form`
        display: flex;
        justify-content: center;
        border: 3px solid #4C3190;
        background: #8AC144;
    `;

const Input = styled.input`
        width: 250px;
        font-size:25px;
    `;

export default function TodoForm({ getTodos }) {
    const [todoIdForFetch, setTodoIdForFetch] = useState();

    const fetchTodoHandler = (e) => {
        fetchTodoById(todoIdForFetch).then(() => getTodos());
        console.log("after")
        e.preventDefault();
    }

    const inputChangeHandler = (value) => {
        setTodoIdForFetch(value);
    }

    return (
        <Form onSubmit={fetchTodoHandler}>
            <Input type='text' name="todoId" placeholder='Todo Id' onChange={(e) => inputChangeHandler(e.target.value)} />
            <FetchTodoButton type='submit' value="Fetch Todo" />
        </Form>
    )
}