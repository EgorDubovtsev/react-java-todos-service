import react, { useEffect, useState } from "react";
import Todo from "./components/todo";
import { getAllTodos } from "./funcs/todos-functions";
import styled from 'styled-components'
import TodoForm from "./components/todo-form";
function App() {
  const [todos, setTodos] = useState([])

  const getTodos = () => {
    getAllTodos()
      .then((todos) => {
        setTodos(todos)
      })
  };

  useEffect(() => {
    if (todos.length == 0) {
      getTodos();
    }
  }, []);

  const TodoContainer = styled.div`
    border: 2px solid #4C3190;
    display: flex;
    flex-wrap: wrap;
  `;

  return (
    <div className="App" >
      <TodoForm getTodos={getTodos} />
      <TodoContainer>
        {todos.map((todos, index) => <Todo todo={todos} key={index} />)}
      </TodoContainer>
    </div>
  );
}

export default App;
