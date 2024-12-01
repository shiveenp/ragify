#!/bin/bash

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

echo "Stopping model"
ollama stop llama3.2
echo "Model stopped"
echo "Stopping docker-compose"
docker-compose -f "$SCRIPT_DIR/../compose.yml" down
echo "docker-compose stopped"
