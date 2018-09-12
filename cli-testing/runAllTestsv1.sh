#!/bin/bash

newman run Heroes.postman_collection_v1.json --timeout-request 20000 -e Heroes.localhost.environment.json -r html,cli,json,junit
