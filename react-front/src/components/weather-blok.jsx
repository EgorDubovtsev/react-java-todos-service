import { useEffect, useState } from "react";
import styled from "styled-components"
import { getAllWeather } from "../funcs/todos-functions";
const MainWrapper = styled.div`
    height:40px;
    font-size: 25px;
    text-align:center;
`;

export default function WeatherBlock(){
    const [weatherInfo,setWeatherInfo] = useState();

    useEffect(()=>{
        getAllWeather().then((weather)=>setWeatherInfo(weather));
    },[]);

    return(
        <MainWrapper>
            {weatherInfo}
        </MainWrapper>
    )
}