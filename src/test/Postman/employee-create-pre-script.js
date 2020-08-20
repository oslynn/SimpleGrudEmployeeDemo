const employee =
{
  "createdStamp": "2020-08-20T12:16:48.475Z",
  "dateOfBirth": "2020-08-20T12:16:48.475Z",
  "dateOfJoining": "2020-08-20T12:16:48.475Z",
  "department": "Technology",
  "email": "ott1.sathngam@gmail.com",
  "isActive": "Yes",
  "lastUpdatedStamp": "2020-08-20T12:16:48.475Z",
  "name": "OTT1 SATHNGAM",
  "role": "SW Eng",
  "skillSets": "API Developer"
};

const options = {
    'method': 'POST',
    'url': 'http://localhost:8080/employee/api/employees',
    'header': {
        'Content-Type': 'application/json'
    },
    body: pm.variables.replaceIn(JSON.stringify(employee))
}


pm.sendRequest(options, function (error, response) {
    console.log("Running Pre-request-sript");
    if (error)
        throw new Error(error);
    console.log(response.body);
});
