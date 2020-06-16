<h1>Deliver For Me!</h1>
<p>Backend Service to manage the user tasks performed on the native app</p>
<p>The idea here is to manage and lift the heavy work from the front end application and provide services to accelerate business process.</p>


<h1>Setup</h1>
<h2>Run Maven</h2>
 <p>mvn clean install</p>

<h2>Start the DB in Container</h2>

docker run -d -p 5555:5432
<p> 
--name deliverforme-db
<p/> 
<p> 
-e POSTGRES_PASSWORD=extraordinaryit
<p/> 
<p> 
-e POSTGRES_USER=extraordinaryit 
<p/>
<p>
-e POSTGRES_DB=deliverformedb
<p/>
postgres:12.3

<br/>

<h2>Run The App</h2>
<p> test users </p>
<ul>
    <li>drivertest</li>
    <li>usertest</li>
    <li>businessusertest</li>
</ul>


