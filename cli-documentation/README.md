# API Documentation from CLI

With postmanerator it is possible to generate documentation from any Postman collection directly from the CLI.
 
#### 1. Export Postman collection

From the Postman desktop client, export your desired collection in "Collection v1" format into this directory.
 
> heroes/cli-docs $ ls
> Heroes.postman_collection_v1.json postmanerator_linux_amd64  README.md

#### 2. Run postmanerator 
You should provide both the api v1 Collection and the output name for your html documentation

> $./postmanerator_linux_amd64 -output=./collection-doc.html -collection=./Heroes.postman_collection_v1.json

#### 3. Open the doc!

Open in any browser the generated collection doc ('collection-doc.html').

> $ chromium-browser Heroes.postman_collection.html

#### Further info...
postmanerator
https://github.com/aubm/postmanerator

# API Documentation Online

Convert Postman collection to Swagger
https://www.apimatic.io/transformer

Then render the generated swagger file on the previous step
https://editor.swagger.io/
