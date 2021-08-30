import { useState } from "react";
import styled from "styled-components"
import {fetchSeveralTodo} from "../funcs/todos-functions"

const FetchTodoButton = styled.input`
    height: 50px;
    width: 180px;
    font-size:25px;
`;
const Input = styled.input`
    width: 250px;
    font-size:25px;
`;

const Form = styled.form`
        display: flex;
        justify-content: center;
        border: 3px solid #4C3190;
        background: #8AC144;
    `;

export default function FetchSeveralForm(){
    const [todoAmount,setTodoAmount] = useState();
    const todoAmountInputChangeHandler = (value)=>{
        setTodoAmount(value);
    }
    const todoAnountSubmitHandler = ()=>{
        fetchSeveralTodo(todoAmount)
    }
    return(
        <Form onSubmit={todoAnountSubmitHandler}>
            <Input type='text' name="todoAmount" placeholder='Todo amount' onChange={(e) => todoAmountInputChangeHandler(e.target.value)} />
            <FetchTodoButton type='submit' value="Fetch Todo" />
        </Form>
    )
}