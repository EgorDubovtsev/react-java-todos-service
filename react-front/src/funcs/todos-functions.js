export async function getAllTodos() {
    console.log("get all todos");
    const response = await fetch('/api/todos');

    return await response.json();
}
export async function fetchTodoById(id) {
    console.log("fetch todo by id: ", id);
    const response = await fetch(`/api/fetchedTodo/${id}`);

    return await response.json();
}

export async function getAllWeather(){
    console.log("Getting weather...");
    const weatherResponse = await fetch("/api/fullTemperatureInfo");
    console.log(weatherResponse);
    
    return await weatherResponse.text();
}