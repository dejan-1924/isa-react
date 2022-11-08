import React from 'react'

export const CenterList = (props:any) => {

  return (
    <div>
        <div>
        {props.centers}
        </div>
        {props.centers.map((center:any)=>{
            <div>a</div>
        })}
    </div>
  )
}
