import { get } from 'http';
import React, { useEffect,useState } from 'react'
import { CenterList } from '../components/CenterList';

export const Centers = () => {

const [centers, setCenters] = useState<any[]>([])

  useEffect(() => {
    fetch("http://localhost:8084/api/center/centers", {
        method: "GET",
        headers: { 
            'Content-Type': 'application/json',
        },
    })
      .then((response) => response.json())
      .then((actualData) => setCenters(actualData));
  }, []);


  return (
    <>
    {centers.map(center => <div>
        <span>{center.name}</span>
        <span>{center.address}</span>
        <span>{center.grade}</span>
        </div>)}

    </>

  )
}
